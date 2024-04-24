// Generated from C:/MiASI_project_mp/src/grammar/GetUMPStx.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GetUMPStx}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GetUMPStxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GetUMPStx#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(GetUMPStx.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GetUMPStx#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(GetUMPStx.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GetUMPStx#kvEq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKvEq(GetUMPStx.KvEqContext ctx);
}